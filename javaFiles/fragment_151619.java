try
        {
            FileVisitResult result = super.visitFileFailed(file, exc);
            return result;
        }
        catch(AccessDeniedException ade)
        {
            MainWindow.logger.warning("Unable to count files in:"+file);
            return FileVisitResult.CONTINUE;
        }