new DownloadFile().execute("Url String"); //you must be doing this

//instead you should do

newTask = new DownloadFile();
newTask.execute("Url String");  // YOUR OBJECT IS IN newTask
...

// keep track of this newTask variable

// when ever you want to cancel just call
newTask.cancel(true); // ADDED BY ME
dialog.dismiss();//In fact, I want to apply the code to stop both Progress Dialog and AsynTask here.