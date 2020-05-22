ThreadPool threadPool = new ThreadPool();
threadPool.setName(executorName.getKeyProperty("name"));
threadPool.setMaxThreads(JmxTools.getIntAttr(server, executorName, "maxThreads"));
threadPool.setMaxSpareThreads(JmxTools.getIntAttr(server, executorName, "largestPoolSize"));
threadPool.setMinSpareThreads(JmxTools.getIntAttr(server, executorName, "minSpareThreads"));
threadPool.setCurrentThreadsBusy(JmxTools.getIntAttr(server, executorName, "activeCount"));
threadPool.setCurrentThreadCount(JmxTools.getIntAttr(server, executorName, "poolSize"));