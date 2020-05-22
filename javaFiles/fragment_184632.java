Instances data;
...

// it's important to iterate from last to first, because when we remove
// an instance, the rest shifts by one position.
for (int i = data.numInstances - 1; i >= 0; i--) {
    Instance inst = data.getInstance(i);
    if (condition(inst)) {
        data.delete(i);
    }
}