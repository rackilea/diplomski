template <class DisplayableObject> 
class TreeDisplay { 
    DisplayableObject const &root;
public:
    TreeDisplay(DisplayableObject const &d) : root(d) {}   

    display(graphic const *g);

    void build_tree(DisplayableObject const &d=root) {
        for (auto child : d.get_children) {
            add_node(d.CreateGraphicNode(this, child));
            build_tree(child);  // recursively add child's children
        }
    }
}