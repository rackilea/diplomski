package main

import (
    "fmt"
    "time"
)

type Container struct {
    value int
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

type iterStream struct {
    *incIter
}

func NewStreamFromIter(it *incIter) iterStream {
    return iterStream{incIter: it}
}

func (is iterStream) Map(f Mapper) mapperStream {
    return mapperStream{iterStream: is, f: f}
}

type mapperStream struct {
    iterStream
    f Mapper
}

func (ms mapperStream) Next() Container {
    return ms.f(ms.iterStream.Next())
}

func main() {
    s0 := NewStreamFromIter(&incIter{})
    s := s0.Map(func(in Container) Container {
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