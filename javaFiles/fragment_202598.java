public class MyTreeWrapper {
    private MyTree treeprop;

    // getter, setter
}

...

ObjectMapper mapper = new ObjectMapper();
MyTreeWrapper wrapper = mapper.readValue(inputStream, MyTreeWrapper.class);
MyTree tree = wrapper.getTreeprop();