class ContactListener : public b2ContactListener
{
public:
    ContactListener();
    ~ContactListener();

    void BeginContact(b2Contact *contact) {...}
    void EndContact(b2Contact *contact) {...}
    void PreSolve (b2Contact *contact, const b2Manifold *oldManifold) {...}
    void PostSolve (b2Contact *contact, const b2ContactImpulse *impulse) {...}
};