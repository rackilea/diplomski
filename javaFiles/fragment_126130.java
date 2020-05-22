public class MyClass {

    List<Label> labels = new ArrayList<>();

    .... other code


    Label charname = new Label(shell, SWT.NONE);
    ...

    // Save in the list
    labels.add(charname);

    .....

    // Access old label
    int index = ... index of label required
    Label oldLabel = labels.get(index);

}