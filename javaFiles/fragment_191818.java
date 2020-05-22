View okStreamRecyclerView = null;
            try {
                okStreamRecyclerView = mainView.findViewById(NEWSFEED_RECYCLER_ID);
                feedView = (okStreamRecyclerView.getClass().getSuperclass()).getSuperclass();
                Method method = feedView.getMethod("getLayoutManager");
                method.setAccessible(true);
                LinearLayoutManager layoutManager = (LinearLayoutManager) method.invoke(okStreamRecyclerView);
                Class llm = layoutManager.getClass().getSuperclass();
                Method m2 = llm.getMethod("scrollToPositionWithOffset",int.class, int.class);
                m2.setAccessible(true);
                m2.invoke(layoutManager,0,0);
            } catch (ClassCastException e){
                log("AN EXECPTON OCCURED WHILE FETCHING VIEW",e);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }