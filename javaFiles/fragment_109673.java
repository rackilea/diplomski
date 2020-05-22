--Original m_master
m_master: {m_id: chararray,m_name: chararray,in_dx: chararray,rolled_up_name: chararray,match_code: chararray,match0: chararray,flag_ind: chararray}

-- Clone m_master into m_master2
m_master2 = FOREACH m_master GENERATE m_id, m_name, in_dx, rolled_up_name, match_code, match0, flag_ind;

-- We are interested only in SE flag_ind (this works as inner query in your question)
m_master2 = filter m_master2 by flag_ind == 'SE';

-- Now join m_master and m_master2
m_master_self_joined = JOIN m_master BY rolled_up_name LEFT OUTER, m_master2 BY rolled_up_name;

-- Now pick fields from m_master
-- When there is a match with m_master2, set flag_ind to SE
m_master_self_joined2 = FOREACH m_master_self_joined 
                        GENERATE 
                            m_master::m_id,
                            m_master::m_name,
                            m_master::in_dx,
                            m_master::rolled_up_name,
                            m_master::match_code,
                            m_master::match0,
                            (m_master::m_id == null ? 'Non SE' : 'SE');

-- Its possible to have duplicates (if rolled_up_name is not unique), so take uniques
m_master_self_joined3 = DISTINCT m_master_self_joined2;