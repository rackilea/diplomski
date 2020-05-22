package main

import "fmt"

type Methoder interface {
    Method()
}

func Function(m Methoder) {
    m.Method()
}

type StructB struct{}

func (s *StructB) Method() { fmt.Println("StructB") }

type StructC struct{} // You can do some "inheritance" by embedding a base struct

func (s *StructC) Method() { fmt.Println("StructC") }

func main() {    
    b := &StructB{}
    Function(b)    
}