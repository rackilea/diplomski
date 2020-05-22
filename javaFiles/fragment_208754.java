Capture<Callback> cap = new Capture<Callback>();
mockA.methodA(capture(cap));
replay(mockA);
instanceOfB.methodB(mockA);
Callback cb = cap.getValue();

// now we can call cb.onResult with a mocked Result instance