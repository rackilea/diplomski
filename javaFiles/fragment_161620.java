CustomProgressBar bar = new CustomProgressBar(yourContext,"Loading");
//onpreexecute
bar.show();
//doInBackground()
do network operations
//onPostExecute()
bar.dismiss()