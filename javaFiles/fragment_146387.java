List<String> list = ...
String str = this.list
                 .stream()
                 .collect(Collector.of(
                    StringBuilder::new,
                    (b ,s) -> b.append(s),
                    (b1, b2) -> b1.append(b2),
                    StringBuilder::toString   //last action of the accumulator (optional)  
                 ));