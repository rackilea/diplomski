package main

import (
    "fmt"
    "time"
)

type Container struct {
    value int
}

type Iterator interface {
    HasNext() bool
    Next() Container
}

type incIter struct {
    i int
}

func (it *incIter) HasNext() bool {
    return it.i < 10000000
}

func (it *incIter) Next() Container {
    it.i++
    return Container{value: it.i}
}

type Mapper func(Container) Container

type Stream interface {
    Iterator
    Map(Mapper) Stream
}

type iterStream struct {
    Iterator
}

func NewStreamFromIter(it Iterator) Stream {
    return iterStream{Iterator: it}
}

func (is iterStream) Map(f Mapper) Stream {
    return mapperStream{Stream: is, f: f}
}

type mapperStream struct {
    Stream
    f Mapper
}

func (ms mapperStream) Next() Container {
    return ms.f(ms.Stream.Next())
}

func (ms mapperStream) Map(f Mapper) Stream {
    return nil // Not implemented / needed
}

func main() {
    s := NewStreamFromIter(&incIter{})
    s = s.Map(func(in Container) Container {
        return Container{value: in.value * 2}
    })

    fmt.Println("Start")
    start := time.Now()

    j := 0
    for s.HasNext() {
        s.Next()
        j++
    }

    fmt.Println(time.Since(start))
    fmt.Println("j:", j)
}