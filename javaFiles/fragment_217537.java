@RequestMapping(value = "/foo/", headers="Accept=*/*", consumes="application/json", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Foo foo) {           
        fooService.saveFoo(foo);
        Set<Bar> bars = foo.getBars();      

        for (Bar bar : bars) {
            bar.setFoo(foo); // this foo object comes from method arg @RequestBody Foo foo above
            barService.savebar(bar);            
        }       

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }