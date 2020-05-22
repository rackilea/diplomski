class DirectoryBrowser { 
    std::vector<directory> children;       
public:
    std::vector<directory> &get_children() { return children; }

    void CreateGraphicNode(TreeDisplay *t, directory const &d) { 
        t->display(d.name);
    }
};