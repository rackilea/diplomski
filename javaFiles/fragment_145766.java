import groovy.transform.Canonical as C

@C class Bar { def bar }

@C class Baz { def baz }

A = { new Bar(bar: it) }

B = { new Baz(baz: it) }


assert A("wot") == new Bar(bar: "wot")
assert B("fuzz") == new Baz(baz: "fuzz")