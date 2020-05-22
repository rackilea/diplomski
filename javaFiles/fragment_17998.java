try {
        project.refreshLocal(IResource.DEPTH_INFINITE, null); 

        IJobManager jobManager = Job.getJobManager();
        jobManager.join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
    } catch (CoreException | OperationCanceledException | InterruptedException  e) {
            e.printStackTrace();
    }