interface Transformer<I, O> {
    O transform(I input);
}

...

public void yourMethod(BufferedReader br, Transformer<String, T> transformer) {

    String element = br.readLine();
    T elem = transformer.transform(element);

    // Do what you want with your new T
}