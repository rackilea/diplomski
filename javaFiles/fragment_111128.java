IRI f22SelfContainedExpression = SimpleValueFactory.getInstance().createIRI("http://example.org/F22_Self-Contained_Expression"); 

 ... 

 if (!st.getObject().equals(f22SelfContainedExpression)) {
      writer.handleStatement(st);
 }