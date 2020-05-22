pid = forkAndExec(prog,
              argBlock, argc,
      envBlock, envc,
      dir,
      redirectErrorStream,
      stdin_fd, stdout_fd, stderr_fd);
stdin_stream = new BufferedOutputStream(new FileOutputStream(stdin_fd));