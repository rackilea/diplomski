final DirectoryWatcher watcher1 = new DirectoryWatcher(path, true,
        new Syncer(path, path2, "some extra key"));
final DirectoryWatcher watcher2 = new DirectoryWatcher(path2, true,
        new Syncer(path2, path, "some extra key part 2"));

final ExecutorService tExecutorService = Executors
        .newCachedThreadPool();
tExecutorService.submit(watcher1::processEvents);
tExecutorService.submit(watcher2::processEvents);