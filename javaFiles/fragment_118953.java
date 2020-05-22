IntStream.iterate(0, i->i+10).limit(51).forEach( a ->
            IntStream.iterate(0, i->i+10).limit(51).forEach( b ->
                    IntStream.iterate(0, i->i+10).limit(51).forEach( c->
                            System.out.println(a + ", " + b + ", " + c)
                    )
            )
);