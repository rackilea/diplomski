int numVertices = (10000); 
      float * vertices = new float[numVertices * 3]; 
      float* normals = new float[numVertices * 3]; 
      //float* textures = new float[numVertices * 2]; 

      // vertices body 
      k = 0; 
      for (i = 0; i < slices; i++) { 
         normals[3 * k] = cos(theta * i); 
         normals[3 * k + 1] = sin(theta * i); 
         normals[3 * k + 2] = 0; 

         vertices[3 * k] = radius * normals[3 * k]; 
         vertices[3 * k + 1] = radius * normals[3 * k + 1]; 
         vertices[3 * k + 2] = .5f; 
         k++; 
      } // end of for vertices on body 

      for (i = 0; i < slices; i++) { 
         normals[3 * k] = cos(theta * i); 
         normals[3 * k + 1] = sin(theta * i); 
         normals[3 * k + 2] = 0; 

         vertices[3 * k] = radius * normals[3 * k]; 
         vertices[3 * k + 1] = radius * normals[3 * k + 1]; 
         vertices[3 * k + 2] = -.5f; 

         k++; 
      } // end of for vertices on body 

     // Generate indices for triangular mesh 
     int numIndices = 100000; 
     unsigned int* indices = new unsigned int[numIndices]; 

     k = 0; 

     for (i = 0; i < slices; ++i) { 
          int i1 = i; 
          int i2 = (i1 + 1) % slices; 
          int i3 = i1 + slices; 
          int i4 = i2 + slices; 

          indices[k++] = i1; 
          indices[k++] = i3; 
          indices[k++] = i2; 

          indices[k++] = i4; 
          indices[k++] = i2; 
          indices[k++] = i3; 
     }