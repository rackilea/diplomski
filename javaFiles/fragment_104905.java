struct QuadTreeNode
{
     // Stores AABB.
     float x1, x2, y1, y2;

     // Stores first child or -1 if empty.     
     int first_child;

     // Stores first element or -1 if this is not a leaf.
     int first_element;
};

struct QuadTree
{
     // Stores all the nodes in the quad tree. The 4
     // children of a node are stored contiguously.
     QuadTreeNode nodes[];

     // Stores all the elements in the quad tree. The
     // elements at the leaves are stored contiguously.
     Element elements[];
};