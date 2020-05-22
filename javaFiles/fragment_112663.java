public abstract class Action {
    private final ImpactType m_impactType;

    Action( ImpactType impactType ) {
         m_impactType = impactType;
    }

    protected final ImpactType impactType() { 
        return m_impactType; 
    }
    ...
 }