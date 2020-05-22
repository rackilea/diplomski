for(int i = 0; i < field.length; i++){
    for(int j = 1; j < field[i].length; j++){
        if(!field[i][0].equals(field[i][j])){
            return false;
        }
    }
}

return true;