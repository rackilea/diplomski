while (sharedArray.isEmpty()||sharedArray.size()<=2)
            {
                try
                {
                    sharedArray.wait();
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            }...