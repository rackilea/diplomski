// 1254 Verticies
// 2141 Texture Coordinates
// 1227 Normals
// 2248 Triangles

static short face_indicies[2248][9] = {
// Object #-1
    {0,15,14 ,0,1,2 ,0,1,2 }, {0,1,15 ,0,3,1 ,0,3,1 }, {1,16,15 ,3,4,1 ,3,4,1 },
    {1,2,16 ,3,5,4 ,3,5,4 }, {2,17,16 ,5,6,4 ,5,6,4 }, {2,3,17 ,5,7,6 ,5,7,6 },
    {3,18,17 ,7,8,6 ,7,8,6 }, {3,4,18 ,7,9,8 ,7,9,8 }, {4,19,18 ,9,10,8 ,9,10,8 },
    //.................................................................
};

static GLfloat vertices [1254][3] = {
{1.32715f,-1.99755f,-0.614826f},{1.32715f,-2.20819f,-0.343913f},{1.32715f,-2.5155f,-0.191263f},
{1.32715f,-2.85867f,-0.187049f},{1.32715f,-3.16964f,-0.332104f},{1.32715f,-3.38686f,-0.597763f},
{1.32715f,-3.46734f,-0.931359f},{1.32715f,-3.39508f,-1.26683f},{1.32715f,-3.18445f,-1.53774f},
    //..................................................................
};

static GLfloat normals [1227][3] = {
{-0.45634f,0.376195f,-0.80637f},{0.456348f,0.688811f,-0.563281f},{0.45634f,0.376194f,-0.80637f},
{-0.456348f,0.688811f,-0.563281f},{0.456341f,0.865005f,-0.208615f},{-0.456341f,0.865005f,-0.208615f},
{0.456341f,0.869868f,0.187303f},{-0.456341f,0.869868f,0.187303f},{0.456349f,0.702436f,0.546196f},
    //..................................................................
};

static GLfloat textures [2141][2] = {
{0.94929f,0.497934f},{0.99452f,0.477509f},{0.994669f,0.497506f},
{0.949142f,0.47796f},{0.994339f,0.457508f},{0.948961f,0.457992f},
};

////////////////////////////////////////////////////////////////
// These are hard coded for this particular example
GLushort uiIndexes[2248*3];   // Maximum number of indexes
GLfloat vVerts[2248*3][3];  // (Worst case scenario)
GLfloat vText[2248*3][2];
GLfloat vNorms[2248*3][3];
int iLastIndex = 0;         // Number of indexes actually used



/////////////////////////////////////////////////////////////////
// Compare two floating point values and return true if they are
// close enough together to be considered the same.
int IsSame(float x, float y, float epsilon)
    {
    if(fabs(x-y) < epsilon)
        return 1;

    return 0;
    }


///////////////////////////////////////////////////////////////
// Goes through the arrays and looks for duplicate verticies 
// that can be shared. This expands the original array somewhat
// and returns the number of true unique verticies that now
// populates the vVerts array.
int IndexTriangles(void)
    {
    int iFace, iPoint, iMatch;
    float e = 0.000001; // How small a difference to equate

    // LOOP THROUGH all the faces
    int iIndexCount = 0;
    for(iFace = 0; iFace < 2248; iFace++)
        {
        for(iPoint = 0; iPoint < 3; iPoint++)
            {
            // Search for match
            for(iMatch = 0; iMatch < iLastIndex; iMatch++)
                {
                // If Vertex is the same...
                if(IsSame(vertices[face_indicies[iFace][iPoint]][0], vVerts[iMatch][0], e) &&
                   IsSame(vertices[face_indicies[iFace][iPoint]][1], vVerts[iMatch][1], e) &&
                   IsSame(vertices[face_indicies[iFace][iPoint]][2], vVerts[iMatch][2], e) &&

                   // AND the Normal is the same...
                   IsSame(normals[face_indicies[iFace][iPoint+3]][0], vNorms[iMatch][0], e) &&
                   IsSame(normals[face_indicies[iFace][iPoint+3]][1], vNorms[iMatch][1], e) &&
                   IsSame(normals[face_indicies[iFace][iPoint+3]][2], vNorms[iMatch][2], e) &&

                   // And Texture is the same...
                   IsSame(textures[face_indicies[iFace][iPoint+6]][0], vText[iMatch][0], e) &&
                   IsSame(textures[face_indicies[iFace][iPoint+6]][1], vText[iMatch][1], e))
                    {
                    // Then add the index only
                    uiIndexes[iIndexCount] = iMatch;
                    iIndexCount++;
                    break;
                    }
                }

            // No match found, add this vertex to the end of our list, and update the index array
            if(iMatch == iLastIndex)
                {
                // Add data and new index
                memcpy(vVerts[iMatch], vertices[face_indicies[iFace][iPoint]], sizeof(float) * 3);
                memcpy(vNorms[iMatch], normals[face_indicies[iFace][iPoint+3]], sizeof(float) * 3);
                memcpy(vText[iMatch],  textures[face_indicies[iFace][iPoint+6]], sizeof(float) * 2);
                uiIndexes[iIndexCount] = iLastIndex;
                iIndexCount++;
                iLastIndex++;
                }
            }
        }
    return iIndexCount;
     }

/////////////////////////////////////////////
// Function to stitch the triangles together
// and draw the ship
void DrawModel(void)
    {
    static int iIndexes = 0;
    char cBuffer[32];


    // The first time this is called, reindex the triangles. Report the results
    // in the window title
    if(iIndexes == 0)
        {
        iIndexes = IndexTriangles();
        sprintf(cBuffer,"Verts = %d Indexes = %d", iLastIndex, iIndexes);
        glutSetWindowTitle(cBuffer); 
        }

    // Use vertices, normals, and texture coordinates
    glEnableClientState(GL_VERTEX_ARRAY);
    glEnableClientState(GL_NORMAL_ARRAY);
    glEnableClientState(GL_TEXTURE_COORD_ARRAY);

    // Here's where the data is now
    glVertexPointer(3, GL_FLOAT,0, vVerts);
    glNormalPointer(GL_FLOAT, 0, vNorms);
    glTexCoordPointer(2, GL_FLOAT, 0, vText);

    // Draw them
    glDrawElements(GL_TRIANGLES, iIndexes, GL_UNSIGNED_SHORT, uiIndexes);
    }