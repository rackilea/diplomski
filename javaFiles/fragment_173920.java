i =0//iteration 1
if(wordToFind.charAt(0) == barray[i]){
    startWord++;// is now 1
    if(startWord > endWord) {//1>3 no

i =1//iteration 2
if(wordToFind.charAt(1) == barray[i]){
    startWord++;// is now 2
    if(startWord > endWord) {//2>3 no

i =2 //iteration 3
if(wordToFind.charAt(2) == barray[i]){
    startWord++;// is now 3
    if(startWord > endWord) {//3>3 no

i =3
if(wordToFind.charAt(3) == barray[i]){//see you are accessing charAt(3)
    startWord++;// is now 4
    if(startWord > endWord) {//4>3 yes