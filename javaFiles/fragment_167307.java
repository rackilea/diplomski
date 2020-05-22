package main

import "fmt"

type Work struct {
    Name string
}

func (t Work) String() string {
    return "Stringer called."
}

func main() {
    w := Work{"Hi"}
    fmt.Println(w)
}