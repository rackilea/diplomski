private static class DeleteAllPetsAsyncTask extends AsyncTask<Void, Void, Integer>
    {
        private PetDao petDaoOfDeleteAllAsyncTask;
        public MutableLiveData<Integer> resultLiveData = new MutableLiveData();

        DeleteAllPetsAsyncTask(PetDao petDao)
        {
            this.petDaoOfDeleteAllAsyncTask = petDao;
        }

        @Override
        protected Integer doInBackground(Void... voids)
        {
            int countOfDeletedRows = this.petDaoOfDeleteAllAsyncTask.deleteAllPets();
            return countOfDeletedRows;
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         *
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param integer The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(Integer integer) {
            //super.onPostExecute(integer);
            // TODO: how to return this integer
            resultLiveData.postValue(integer);
        }
    }

    // this function is inside repository
    public LiveData<Integer> deleteAllPets()
    {
        DeleteAllPetsAsyncTask task = new DeleteAllPetsAsyncTask(this.petDao);
        task.execute();
        // I edited here
        return task.resultLiveData;
    }