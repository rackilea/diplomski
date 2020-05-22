loginButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Login myLoginTask = login; // keep a reference to the current task
            login = new Login(... arguments ...); // create a new task for the next click

            try {
                // use the original task
                myLoginTask.execute(email, password).get();
            }
            catch(Exception e){ }
}