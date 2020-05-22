while(in.hasNextInt()){
    contents[i++]=in.nextInt();
}

// 'i' now contains the number read from the file:
for (int n = 0; n < i; ++ n)
    System.out.println(contents[n]);