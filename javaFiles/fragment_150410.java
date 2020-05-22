public static boolean fuelleArray(int y, int x, int zahl){

    sudokuArray[y][x]=zahl;

    if(zahlIstGueltigAufPosition(y,x,zahl)){
                                       //#1
        if(x==8 && y<=7){              //if you aren't at the end
            if(fuelleArray(y+1,0,1)){  //look if the the next field
                return true;           //is correct
            }
                                       //#2
        }else if(x==8 && y==8){        //if I am at the end 
            return true;               //return true, cause at 
                                       //zahlIstGueltigAufPosition
                                       //we know its correctly plassed               
                                       //by the SudokuRules


        }else if(x<=7 && y<=8){        //Just like #1, but there it
            if(fuelleArray(y,x+1,1)){  //was to handle the end of a 
                return true;           //row

            }
        }
    }

    if(zahl<9 && x<=8 && y<=8 ){      //if we are not correct we
        if(fuelleArray(y,x,zahl+1)){  //increase the number in that
            return true;              //field

        }
    }else {                           //if we are at number 9 we put 
        sudokuArray[y][x]=0;          //put it back to zero
                                      //
    }                                 //
    return false;                     //and return false

}