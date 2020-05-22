for(Skill skill:job.getSkills()){
                    DetachedCriteria subquery = DetachedCriteria.forClass(Skill.class,"skill");
                    subquery.add(Restrictions.eq("id",skill.getId()));
                    subquery.setProjection(Projections.property("id"));
                    subquery.createAlias("jobs", "job");
                    subquery.add(Restrictions.eqProperty("job.id", "Job.id"));
                    criteria.add(Subqueries.exists(subquery));  
                }