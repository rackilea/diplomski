int[] sharedIds = shaders.stream().mapToInt((WrappedShader shader) -> {
            int shader_id = glCreateShader(shader.getShader_type());
            glShaderSource(shader_id, shader.getShader_source());
            glCompileShader(shader_id);
            glAttachShader(shader_program, shader_id);
            return shared_id;
      }).toArray();