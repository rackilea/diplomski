//I think from here on out I will just write the code...
//20 min later...this stupid @$$ message box is the worst
//dev environment I have EVER! worked in...
//......(granted it isn't that)
//40 min later in Visual Studio. Tired of working without
//a net...no KB short cts...NO TAB! no auto formatting...?

template<class T>
class IcanOnlyBeaBT;//fwd _decl 
                //or a doubley linked list, an Adapter, a...
                //keep thinking as you go...
template<class T>
class INode
{   
    friend class IcanOnlyBeaBT<T>;//this takes care of access
public:

//  At this level we have protected
//  access for derived classes--
//  EXCEPT! with TEMPLATED classes!
//  in C++ this is NOT an issue WHEN.
//  1. data members are 'captured' by
//     template instantiation
//  2. and 3. are the exact same answer
//     as 1. only I would be forced to
//     elaborate on two specific instances
//     with the only advantage being a 
//     sufficing ward on those nit-pickers
//     who love to leave comments like
//
//          "Weellll...NOT exactly"
//
//          I dont care. I would rather
//          write my explaination for not 
//          explaining further...

        /************************************/
        // (no worries here in java - C#)
        // implement now to enforce the
        // design on higher level abstractions;
        // protected access may become 
        // private in remote derived classes
        // we never want to come back here!!!
        // push dependencies up! up! up!


     INode() : whatever_Data_I_want_Ha_Ha(nullptr) {}
     virtual void SetWhatEverDataIWant(T*) = 0;
     virtual T* GetWhateverDataIWant() = 0;
     virtual T* GetWhateverDataIWant() const = 0;
 protected:
     virtual ~INode() = 0;
     T* whatever_Data_I_want_Ha_Ha;
     INode<T>*left_child;
     INode<T>*right_child;
 };

 template<class T>
 INode<T>::~INode() {} // don't worry about this it's cool
                      //...notice that   
                  // the member is protected...and pure virtual...
                  // it's just a boomerang--    

    // Notice how adaptable this Interface has become
    // after only one extension and implementation is refined. 

    // This is BOTTOM UP because we are BUILDING... 
    // ...this should be TOP DOWN as we DESIGN...
    // THINK--TOP DOWN...BUILD BOTTOM UP...

    // Push ALL negotiable DEPENDENCIES UP AS YOU BUILD.
    // Ideally, these were identified during design.
    // It rarely ever goes that way cleanly...
    // at least not for me, but try...try

    // As incremental implementation progresses, You
    // may start to identify some of these negotiable
    // dependencies...these two interfaces are still
    // super lean..and rather boring, but continue towards
    // the AVL, Red Black, Other Data structurs they will show.

    // Nodes are, for the most part, like a drawer full
    // of silverware. They CAN'T do anything unless
    // they are being used.

    // GO UP now!!!...BUT always JUST enough!!
    // No more; GOAL...to have a DESIGN SPECIFIC
    // hierarchy, that IS extensible in a MODULAR 
    // fasion, like LEGOS. ADAPTABLE to ANY COMPATIBLE
    // Data Structure, Not just TREES. Even from here...
    // there are other suitablilities coming to mind,
    // such as Graphs, Doubley Linked Lists, circular queues.
    // Nodes are common place in Data Structures...on...on...

    // Principle Attribute: ICanBe_A_BST Data Struct now.

    // fwd _decl: 
  template<class T>     
  class ICanBe_A_BST; //The BT Node was FIRST Abstraction, 
                // BST is SECOND.
                // OR a Composite Object Structure! for the  
                // Composite Design Pattern...or...or...or
                // BECAUSE, this IOrderedNode is more QUALIFIED 
                // and adaptable. LOOK HERE! Don't throw away
                // the specific sutibility of lower abstractions
                // This should be extended to fulfil design reqs
                // IOrderedNode is not intended to be a BT, 
                // IT 'IS A' BT by extension, BUT, it is a BST Node.

                // This abstract hierarchy, UPON DESIGN COMPLETION  
                // Will have pervasive extensibility @ unique levels.  
                // think {OPEN-CLOSED} open for EXTENSION, and
                // CLOSED for MODIFICATION...GOAL...DON'T...come
                // BACK inside this BLACK BOX once it is CLOSED..!  

template<class T>
class IOrderedNode : public INode<T>
{ 
              // RIGHT HERE! ALL previous implementation
              // Is abstracted AWAY. Look how clean it all is..
              // in java you would be Extending INode Interface HERE!.
              // Extending IN JAVA IS inheritance.
              // ALL public and protected members.
              // Closed for MOD. open for EXTENSION
public:                                
    IOrderedNode() : height(0) { }

protected:
//NOTICE!(I Can Be A BST Node IF!)my data is INTEGRAL & comparable.
//FOR instance a bool is unqualified--how can you order a tree
//when the only value is a 1 or a 0;
//UDT is dependent upon guess...
//THE USER who defind it(integral && comparable);

// Question: is there anything missing from this level 
// that would disqualify concrete instantiations from adequately
// filling the intended role? .....Seriously...
// I have been awake for two days now. This may need editing. 
// Regardless the process is the 
// same all the way to Red Black and beyond...

int height; //new data member; height of the tree at that node...
            //this comes in handy when computing the balance factor
            //on balanced trees...AVL, R&B,
};



/***********************NOTE:***********************
*
*   There are several considerations that have to be made 
*   when you are "leaving" data and and implementation "behind". 
*   We know we don't EVER want to come back here...
    (not a super realistic GOAL...)
*   Is the implementation specific to the level of bstraction.?...
*   YES? then leave it here. 

    IS...the DATA specific to the implementation ????
*   this deserves 4 Q-marks because, IF at all POSSIBLE PUSH
*   these IMPLEMENTATION DEPENDENCIES..UP This RESULTS in IoC
*   Inversion of Control Inversion of CONTROL INVERSION! of Control...
*   Implementation dependencies should come from higher level abs
*   to lower level Implementation...repeats you are seeing all over
    this now TLDR, are Cardinal principles of Object
*   Oriented Design. Not because I love commenting code...
    but since YOU asked...I won't leave out the 'life blood'.

*   Incidentally, there is a requisite 
    'AHAAH moment' that either comes
*       or it doesn't.
*
****************************   PERSONAL NOTE:*********************
*
*   I picked up java in the late 90's, and was like.
*   "...what the hell is an OBJECT..?" Two years of programming from a
*   procedural paradigm, in an OOP language-LATER! It hit me......
*   (I know...slow learner)...but I remember saying out loud....
*   'THAT...IS...THE...COOLEST...THING...I HAVE EVER...tripped over...
*   Consensually, OOP is considered to be in its INFANCY. 
*   Theories (opinions) are often the cause of some rather heated
*   contest. In fact, one of the most intense and persistant 
    "cival-war" I have ever encountered, nearly dominated an entire 
    forum. I didn't really know enough to have an opinion
*   one way or the other on the matter, but I remember thinking, 
    how absurd...and laughing alot.
*   The theoretical epicenter was localized on the issue of...
        wait for it...
*
*                   INHERITANCE v.s. COMPOSITION/AGGRAGATION
*
*       Hmm....Everybody knows that programming to interfaces, 
    adhereing to common sense, established design principles, 
    and proven patterns, can all be accomplished without inheriting
    from a single archtype...
*        "Not that there's anything wrong with that..." 
    I'm pretty sure, that was the vein of the row on that
         forum...Super entertaining though...
*
*******************************************/