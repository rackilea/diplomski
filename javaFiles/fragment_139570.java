HSLFSlide slide = ...;
Slide<HSLFSlideShow> oops = slide;

// perfectly legal
// probably throws a ClassCastException somewhere
oops.<SomeOtherNotes>set(new SomeOtherNotes());