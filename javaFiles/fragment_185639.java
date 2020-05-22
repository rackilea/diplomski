while(in.hasNextInt()){
    contents[i++]=in.nextInt();
}

// 'i' now contains the number read from the file:
contents = Arrays.copyOf(contents, i);
// contents now only contains 'i' items.
System.out.println(Arrays.toString(contents));