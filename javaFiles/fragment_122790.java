PreparedStatement ps = session.prepare("INSERT INTO messages (user_id,msg_id, title, body) VALUES (?, ?, ?, ?)");
BatchStatement batch = new BatchStatement();
batch.add(ps.bind(uid, mid1, title1, body1));
batch.add(ps.bind(uid, mid2, title2, body2));
batch.add(ps.bind(uid, mid3, title3, body3));
session.execute(batch);