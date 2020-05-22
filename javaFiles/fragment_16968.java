ArrayList<Integer> badIndices = new ArrayList<Integer>();

for (int i=0; i<students.size ; i++) 
{
    if (students.get(i).matches(".*,\\s?,.*")) {
        badIndices.add(i);
    }
}

for (int b : badIndices)
{
    student.remove(b);
}