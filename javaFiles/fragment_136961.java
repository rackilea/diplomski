vector<vertex> vertices; //All the vertices in my object, this includes the position, texture coordinate and normal
vector<vector<int>> synonyms; // For each vertex, the array of vertices which are the same (cloned vertices)
vector<int> normalIndex;
vector<int> UV index;
int normalIn;
int textureIn;
int vertexIn; //each elements in one point of my face declaration in the obj file vertexIn/textureIn/normalIn

funtion(all of the above)
{

    vector<int> synonymsVertex = synonyms[vertexIn]; //We get the synonyms of the vertex we want to add
    for(int vertexClone : synonymsVertex)
    {
        vertex vertexObj = vertices[vertexClone];
        //In the case the combination doesn't exist, we clone the vertex and add it to the list
        if(vertexObj.normal != normalIn || vertexObj.UV != textureIn)
        {
             vertex newVertex(vertexObj, normalIn, textureIn);
             vertices.push_back(newVertex);
             synonymsVertex.push_back(vertices.size - 1);
        }
    }
}