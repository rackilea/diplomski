QEquipment equipment = QEquipment.equipment;
QTeam team = QTeam.team;
QLaboratory laboratory = QLaboratory.laboratory;

Predicate predicate = JPAExpressions
       .selectOne()
       .from(team)
       .where(equipment.laboratory.id.eq(laboratory.id),
              laboratory.id.eq(team.laboratory.id),
              team.registerEquipment.eq(Boolean.TRUE),
              team.person.id.eq(userService.getCurrentId())).exists();