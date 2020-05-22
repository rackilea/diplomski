scene.registerUpdateHandler(new IUpdateHandler()
    {

        @Override
        public void onUpdate(float pSecondsElapsed) {
            if(!taskList.isEmpty())
            {
                for(int i = 0; i < taskList.size(); i++)
                {
                    taskList.get(i).move();
                }
                taskList.clear();
            }

        }

        @Override
        public void reset() {
            // TODO Auto-generated method stub

        }
    });