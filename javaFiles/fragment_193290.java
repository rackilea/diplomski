for(int i=0;i<9;i++){
    System.out.print("Enter your letter : ");
    char user_input_letter = enter.next().charAt(0);
    if(word_to_search.indexOf(user_input_letter)>=0){
        System.out.println("The letter exists !!");
    }
    else{
        System.out.println("This letter does not exist ! ");
    }
}