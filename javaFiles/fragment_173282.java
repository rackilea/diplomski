public class YourTask extends AsyncTask<ArgumentType,null, valueToReturn>{

protected valueToReturn doInBackground(ArgumentType..args){
        while(true){
            //your code here 

            if(isCancelled()){
                            return null;
                    }
        }
    }

}