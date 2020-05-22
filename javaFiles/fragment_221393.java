for(int i = 0; i<mainArr.length; i++){
    mainArr[i] = i;
}

swapper(3, 14, mainArr);

for(int i = 0; i<mainArr.length; i++){
    System.out.print(i + mainArr[i] + " ");
}