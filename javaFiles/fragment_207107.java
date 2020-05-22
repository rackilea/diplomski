@Transactional
        @Override
        public void incrementNoteCounterForGroupCanvas(int canvasId) {
            final Session session = this.sessionFactory.getCurrentSession();
            final GroupCanvas groupCanvas = session.get(GroupCanvas.class, canvasId,LockMode.PESSIMISTIC_WRITE);
            session.refresh(groupCanvas);
            groupCanvas.setNoteCount(groupCanvas.getNoteCount()+1);
            session.saveOrUpdate(groupCanvas);
            session.flush();
        }