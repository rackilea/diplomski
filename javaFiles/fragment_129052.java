int nMoments = 1000;
dataset = new DynamicTimeSeriesCollection(1, nMoments, new Second());
Calendar c = Calendar.getInstance();
c.setTime(new Date(0));
c.add(Calendar.SECOND, -nMoments);
dataset.setTimeBase(new Second(c.getTime()));