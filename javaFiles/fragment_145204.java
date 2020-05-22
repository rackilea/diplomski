// cast expected to object so that created matcher is Matcher<Object>
assertThat(myObject, CoreMatchers.equalTo((Object)myDouble));

// cast actual value to double so that both value and matcher are Double
assertThat((Double)myObject, equalTo(myDouble));

// cast Matcher to raw type so generics will be ignored
assertThat(myObject, (Matcher) equalTo(myDouble));