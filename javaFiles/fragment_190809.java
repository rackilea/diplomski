import java.awt.Component;
import java.util.Enumeration;
import javax.help.*;
import javax.help.plaf.basic.BasicTOCNavigatorUI;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

public class Nav
{
    private static DefaultMutableTreeNode match = null;

    private Nav()
    {
    }

    public static void navigate(HelpSet set, HelpBroker broker, String id, String nodeLabel)
    {
        broker.setCurrentID(id);
        JHelp jhelp = new JHelp(set);
        JHelpNavigator nav = getNavigator(jhelp);
        JTree tree = getTree(nav);
        TreeModel model = tree.getModel();
        Object root = model.getRoot();
        match = null;
        findNode(model, root, nodeLabel);
        TreePath path = new TreePath(match.getPath());
        tree.setSelectionPath(path);
        tree.scrollPathToVisible(path);
    }

    //http://www.google.com/codesearch/p?hl=en#WiboLAWeTd0/xena/ext/src/javahelp/jhMaster/JavaHelp/src/new/javax/help/WindowPresentation.java&t=0&d=30&l=272
    private static JHelpNavigator getNavigator(JHelp jhelp)
    {
        JHelpNavigator nav = null;
        for (Enumeration e = jhelp.getHelpNavigators(); e.hasMoreElements(); ) 
        {
            nav = (JHelpNavigator) e.nextElement();
            if (nav.getNavigatorName().equals("TOC"))
            {
                return nav;
            }
        }
        return null;
    }

    //http://forums.sun.com/thread.jspa?threadID=350180#1459484
    private static JTree getTree(JHelpNavigator nav)
    {
        JTree tree = null;
        Component[] components = nav.getComponents();
        int count = components.length;
        int i = 0;
        while(i < count && !(components[i] instanceof JScrollPane))
        {
            i++;
        }
        if(i < count)
        {
            JScrollPane sp = (JScrollPane) components[i];
            components = sp.getViewport().getComponents();
            count = components.length;
            i = 0;
            while(i < count && !(components[i] instanceof JTree))
            {
                i++;
            }
            tree = (JTree) components[i];
        }
        return tree;
    }

    //http://www.rkcole.com/articles/swing/TraverseJtree-2000-11-17.html
    private static void findNode(TreeModel model, Object o, String search)
    {
        if(match != null)
            return;

        int count = model.getChildCount(o);
        for( int i=0;  i < count;  i++ )
        {
            Object child = model.getChild(o, i );
            if (  model.isLeaf( child ) )
            {
                if(search.equals(((TOCItem)((DefaultMutableTreeNode)child).getUserObject()).getName()))
                {
                    match = (DefaultMutableTreeNode)child;
                    return;
                }
            }
            else
                findNode( model, child, search );
        }
    }
}