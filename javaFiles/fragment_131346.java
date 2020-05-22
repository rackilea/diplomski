Mono.zip(customMono, booleanMono, stringMono).flatMap(data->{
 data.getT1();
 data.getT2();
 data.getT3();
 return Mono.just(<your_response_object>);
});